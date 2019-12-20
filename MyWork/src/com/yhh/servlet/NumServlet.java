package com.yhh.servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class NumServlet extends HttpServlet {
	
	
	@Override
	public void init() throws ServletException {
		//获取文件中的计数器数据
			//获取文件路径
			String path=this.getServletContext().getRealPath("/nums/nums.txt");
			//声明流对象
			FileReader fr=null;
			BufferedReader br=null;
			try {
				fr=new FileReader(path);
				br=new BufferedReader(fr);
				int nums=Integer.parseInt(br.readLine());
				System.out.println(nums+"happy");
				this.getServletContext().setAttribute("nums", nums);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	//覆写销毁方法，存储计数器到文件中
		@Override
		public void destroy() {
			//获取网页计数器
			int nums=(int) this.getServletContext().getAttribute("nums");
			//获取文件路径
			String path=this.getServletContext().getRealPath("/nums/nums.txt");
			//声明流对象
			BufferedWriter bw=null;
			FileWriter fw=null;
			try {
				fw=new FileWriter(path);
				bw=new BufferedWriter(fw);
				bw.write(nums+"");
				//System.out.println("写进去了");
				bw.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	
	
	
}

