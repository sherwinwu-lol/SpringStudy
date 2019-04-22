package impl.method;

import com.alibaba.fastjson.JSON;
import impl.model.PayCheck;

public class HoldMethod implements PaymentMethod {
    @Override
    public void pay(PayCheck pc) {
        System.out.println("HoldMethod.pc:" + JSON.toJSONString(pc));
    }
}
