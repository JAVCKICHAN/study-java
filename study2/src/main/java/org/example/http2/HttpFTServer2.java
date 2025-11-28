package org.example.http2;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//mp4파일을 http로 브라우저에 전송하기(강사님 수정 후)
//멀티쓰레드, 예외처리 깔끔하게 안 되어 있어서 불안정한 코드
//브라우저는 여러 번 호출하기 때문에 멀티쓰레드 처리가 필요하다
public class HttpFTServer2 {
    //bad code
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(5555);

        System.out.println("FTserver run.............");

        byte[] buffer = new byte[1024*8]; //8kb

        while(true){

            Socket socket = serverSocket.accept();

            //브라우저의 /슬래시 뒤를 읽어들이는 코드
            InputStream in = socket.getInputStream();
            Scanner scanner = new Scanner(in);
            String first = scanner.nextLine();
            System.out.println(first);

            if(!first.startsWith("GET /video")){
                scanner.close();
                socket.close();

                continue;
            }

            OutputStream outputStream = socket.getOutputStream();

            File target = new File("/Users/kimda/study-java/image/movie-copy.mp4");
            InputStream inputStream = new FileInputStream(target);

            // HTTP에 맞는 image/png 헤더 메시지를 outputStream에 기록
            outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
            outputStream.write("Content-Type: video/mp4;\r\n".getBytes());
            outputStream.write( ("Content-Length: "+target.length()+"\r\n").getBytes());
            outputStream.write("\r\n".getBytes());

            while(true){
                try {
                    int count = inputStream.read(buffer);//내용물은 buffer에 있고,
                    if (count == -1) {
                        break;
                    }
                    outputStream.write(buffer, 0, count);
                }catch(Exception e){
                    System.out.println("Exception");
                    break;
                }

            }//end while
            outputStream.close();
            socket.close();
        }//end while
    }
}
