package gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Main {


    public class Bean {


        /**
         * type : 1
         * typeName : 9.9包邮
         */

        private int type;
        private String typeName;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }
    }


    public static void main(String args[]) {

        //v1

        String bean = "[{\"type\":1,\"typeName\":\"9.9包邮\"},{\"type\":2,\"typeName\":\"超值大额券\"},{\"type\":3,\"typeName\":\"夏日上新\"}]";

        Type type =new TypeToken<List<Bean>>() {}.getType();
        List<Bean> beanList = new Gson().fromJson(bean, type);

    }

}








