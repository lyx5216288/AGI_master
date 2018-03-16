package lottie.zkr.com.abctest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by 刘洋旭 on 2017/8/10.
 */
public class MainActivity extends Activity {
    public EditText data;
    public Button btn;
    public TextView imsi,stmsi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
            final byte[] m=new byte[]{0x40,0x04,0x48,0x30,0x28,0x28,0x58};
        data= (EditText) findViewById(R.id.bitdata);
        btn= (Button) findViewById(R.id.jiexi);
        imsi= (TextView) findViewById(R.id.imsi);
        stmsi= (TextView) findViewById(R.id.stmsi);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer str=new StringBuffer();
//                for (int i=0;i<m.length;i++){
//                    str.append(byteToBit(m[i]));
//                }
//                createFileWithByte(m);
                U8 x=new U8(m[1]);
                String bit=Integer.toBinaryString(x.getBase());
                if (bit.length()<8){

                }
                imsi.setText(x.getBase()+"::::"+x.getBytes()+"::::"+Integer.toBinaryString(x.getBase()));
            }

        });


    }

    private void createFileWithByte(byte[] bytes) {
        // TODO Auto-generated method stub
        /**
         * 创建File对象，其中包含文件所在的目录以及文件的命名
         */
        File file = new File(Environment.getExternalStorageDirectory(),
                "pagingdata.doc");
        // 创建FileOutputStream对象
        FileOutputStream outputStream = null;
        // 创建BufferedOutputStream对象
        BufferedOutputStream bufferedOutputStream = null;
        try {
            // 如果文件存在则删除
            if (file.exists()) {
                file.delete();
            }
            // 在文件系统中根据路径创建一个新的空文件
            file.createNewFile();
            // 获取FileOutputStream对象
            outputStream = new FileOutputStream(file);
            // 获取BufferedOutputStream对象
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            // 往文件所在的缓冲输出流中写byte数据
            bufferedOutputStream.write(bytes);
            // 刷出缓冲输出流，该步很关键，要是不执行flush()方法，那么文件的内容是空的。
            bufferedOutputStream.flush();
        } catch (Exception e) {
            // 打印异常信息
            e.printStackTrace();
        } finally {
            // 关闭创建的流对象
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static String byteToBit(byte b){
        return ""+(byte)((b>>7)&0x1)+
                (byte)((b>>6)&0x1)+
                (byte)((b>>5)&0x1)+
                (byte)((b>>4)&0x1)+
                (byte)((b>>3)&0x1)+
                (byte)((b>>2)&0x1)+
                (byte)((b>>1)&0x1)+
                (byte)((b>>0)&0x1);
    }
}

