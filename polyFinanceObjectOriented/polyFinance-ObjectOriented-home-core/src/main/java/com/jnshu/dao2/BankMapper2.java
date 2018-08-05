package com.jnshu.dao2;

import com.jnshu.Domain2.DomainBank;
import com.jnshu.dto2.BankListRPO;
import com.jnshu.entity.Bank;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "bankMapper2")
public interface BankMapper2 {

    //新增
    @Insert("insert into bank (create_at ,create_by, update_at, update_by, bank_name, payment_id, withdrawal_id, single_limited, day_limited, icon) values(#{createAt}, #{createBy},#{updateAt},#{updateBy},#{bankName},#{paymentId},#{withdrawalId},#{singleLimited},#{dayLimited},#{icon})")
    @Options(useGeneratedKeys = true)
    Long saveBank(Bank bank) throws Exception;

    //删除--id
    @Delete("delete from bank where id=#{id}")
    Boolean deleteBank(Long id) throws Exception;

    //更新--Bank
    @Update("update bank set update_at=#{updateAt}, update_by=#{updateBy}, bank_name=#{bankName}, payment_id=#{paymentId}, withdrawal_id=#{withdrawalId}, day_limited=#{dayLimited}, icon=#{icon} where id=#{id}")
    Boolean updateBank(Bank bank) throws Exception;

    //总数
    @Select("select count(*) from bank")
    Integer getTotal() throws Exception;

    //查询--id
    @Select("select id, bank_name, payment_id, withdrawal_id, single_limited, day_limited, icon from bank where id = #{id}")
    Bank getBankById(Long id) throws Exception;

    //通过银行名查询。如果存在不新增
    @Select("select id from bank where bank_name=#{bankName}")
    Long getBankIdByBankName(String bankName) throws Exception;

    //查询--多条件
    @SelectProvider(type =BankDaoProvider.class,method = "getBanks")
    List<DomainBank> getBankList(BankListRPO rpo) throws Exception;

    class BankDaoProvider{
        public String getBanks(BankListRPO rpo){
            return new SQL(){{
                SELECT("a.id, a.bank_name, a.payment_id, a.withdrawal_id, a.single_limited, a.day_limited, b.login_name as update_by, a.update_at");
                FROM("bank a");
                INNER_JOIN("user_back b on a.update_by=b.id");
                if (null != rpo.getBankName()){
                    WHERE("a.bank_name like '%" + rpo.getBankName()+"%'");
                }
                if (null != rpo.getUpdateBy()){
                    WHERE("b.login_name=#{updateBy}");
                }
                if (null != rpo.getUpdateAt1() && null != rpo.getUpdateAt2()){
                    WHERE("a.update_at between #{updateAt1} and #{updateAt2}");
                }
                if (null != rpo.getSingleLimited1() && null != rpo.getSingleLimited2()){
                    WHERE("a.single_limited between #{singleLimited1}  and #{singleLimited2} ");
                }
                if (null != rpo.getDayLimited1() && null != rpo.getDayLimited2()){
                    WHERE("a.day_limited between "+rpo.getDayLimited1()+" and "+rpo.getDayLimited2());
                }
            }}.toString();
        }
    }
}
