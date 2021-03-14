import com.google.gson.Gson;

public class Test {

    public static void main(String[] are){
        String url = "https://yxdint.tongdao.tech:21443/backup/uaa/current";
        String json = "";
        String alertUrl = "https://yxdint.tongdao.tech:21443/backup/logic/driving/v1/tenant/storage/consumption/info";
        String token = "";
        StorageInfo storageInfo = new StorageInfo("792167268883628035","1234","zaibei","DONG_CHONG","GOVERNMENT_EXTRANET","LOCAL","PLAIN",1234567);
        HttpUtils.sendByPostJson(alertUrl,new Gson().toJson(storageInfo),token);
    }


    public void test2(){
        String url = "https://yxdint.tongdao.tech:21443/backup/uaa/current";
        String json = "";
        String alertUrl = "https://yxdint.tongdao.tech:21443/backup/logic/driving/v1/alert/info";
        String token = "";
        AlertInfo alertInfo = new AlertInfo("792167268883628035","123","SERIOUS",
                "DONG_CHONG","GOVERNMENT_EXTRANET","123.123.123.123","zaibei2"
                ,"备份","备份主机","备份作业10.24.68.02_D执行失败","20201231160800123","EVENT");
        String result = HttpUtils.sendByPostJson(alertUrl,json,token);
        System.out.println(result);
    }

    public void test3(){//{"message":"成功","status":0,"content":{"id":"1615580712136"}}
        String url = "https://yxdint.tongdao.tech:21443/backup/uaa/current";
        String json = "";
        String alertUrl = "https://yxdint.tongdao.tech:21443/backup/logic/driving/v1/tenant/storage/consumption/info";
        String token = "";
        StorageInfo storageInfo = new StorageInfo("792167268883628035","1234","zaibei","DONG_CHONG","GOVERNMENT_EXTRANET","LOCAL","PLAIN",1234567);
        HttpUtils.sendByPostJson(alertUrl,new Gson().toJson(storageInfo),token);
    }


}
