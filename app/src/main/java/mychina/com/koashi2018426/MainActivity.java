package mychina.com.koashi2018426;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn1)
    Button json;
    @BindView(R.id.btn2)
    Button table;
    @BindView(R.id.btn3)
    Button pic;
    @BindView(R.id.img)
    ImageView imageView;
    //        使用封装后的OKhttp,所定义的成员变量
    private OKhttpManager manager = OKhttpManager.getInstance();

    private String json_path="http://apiv4.yangkeduo.com/subject_collection/18?pdduid=";
    private String pic_path="http://imgsrc.baidu.com/image/c0%3Dshijue1%2C0%2C0%2C294%2C40/sign=3d2175db3cd3d539d530078052ee8325/b7003af33a87e950c1e1a6491a385343fbf2b425.jpg";
    private String post_path="http://blog.csdn.net/qiaoshi96_bk/article/details/77371035";
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }
    //设置点击事件
    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
//这里调用获取网络Json串封装的方法
                manager.asyncJsonStringByURL(json_path, new OKhttpManager.Func1() {
                    @Override
                    public void onResponse(String result) {
                        Log.e("TAG",result);
                    }
                });
                break;
            case R.id.btn2:
//                表单提交的方法向服务器提交账号或者是密码
                final HashMap<String, String> map = new HashMap<>();
                map.put("qs","1008611");
                manager.sendComplexForm(post_path,map, new OKhttpManager.Func1() {
                    @Override
                    public void onResponse(String result) {
                        Log.e("TAG"+map.getClass().getName(),result);
                    }
                });

                break;
            case R.id.btn3:
//                获取图片使用Bitmap加载
                manager.asyncGetByteByURL(pic_path, new OKhttpManager.Func2() {
                    @Override
                    public void onResponse(byte[] result) {
                        bitmap =  BitmapFactory.decodeByteArray(result, 0, result.length);
                        imageView.setImageBitmap(bitmap);
                        Map<String,String>maps = new HashMap<>();
                        OkUtils.UploadFileCS(HttpUrlUtils.UPLOADURL, "photo", "pic_path", maps, new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                Toast.makeText(MainActivity.this,"成功",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

                break;
        }
    }
}
