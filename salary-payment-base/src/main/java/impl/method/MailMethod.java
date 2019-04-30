package impl.method;

import com.alibaba.fastjson.JSON;
import impl.model.PayCheck;
import lombok.Data;

@Data
public class MailMethod implements PaymentMethod {
    private String address;

    public MailMethod() {
    }

    public MailMethod(String address) {
        this.address = address;
    }

    @Override
    public void pay(PayCheck pc) {
        System.out.println("MailMethod.pc:" + JSON.toJSONString(pc));
    }
}
