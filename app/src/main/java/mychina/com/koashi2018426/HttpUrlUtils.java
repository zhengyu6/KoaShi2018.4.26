package mychina.com.koashi2018426;


/**
 * Created by ${周康} on ${Study}.
 */

public class HttpUrlUtils {
    public static final int IO_BUFFER_SIZE = 10 * 1024;
    public static final String URL = "http://192.168.190.188/Goods";
    public static final String URL_LOGIN = URL + "/app/common/login.json";
    public static final String URL_PUBLISHED = URL + "/app/user/issue_list.json";
    public static final String URL_HASCONCERNED = URL + "/app/user/follow_list.json";
    /*
*	个人信息
* */
    public final static String URL_INFORMATION = URL + "/app/user/info.json";

    public static final String URL_FOLLOW = URL + "/app/item/follow.json";

    /*商品列表查询
 * */
    public final static String URL_LIST = URL + "/app/item/list.json";
    /*
* 下载图片前缀
* */
    public static final String URL_IMGURL = URL + "/uploads/";


    //上传头像网址
    public static final String UPLOADURL = URL + "/app/user/upload.json";

    //验证邀请码网址
    public static final String INVITEURL = URL + "/app/user/invite.json";
    //用户注册网址
    public static final String REGISTERURL = URL + "/app/common/register.json";
    //发布商品网址
    public static final String ISSUEURL = URL + "/app/item/issue.json";

    //商品列表查询网址
    public static final String LISTURL = URL + "/app/item/list.json";

    //商品详细查询网址
    public static final String DETAILURL = URL + "/app/item/detail.json";

    //商品状态变更网址
    public static final String MODIFYURL = URL + "/app/item/modify.json";

    //是否关注商品网址
    public static final String FOLLOWURL = URL + "/app/item/follow.json";


}
