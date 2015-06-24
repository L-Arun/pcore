/**
 * 
 */
package com.lehecai.core.test.string;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import com.lehecai.core.lottery.plan.PlanContent;
import com.lehecai.core.lottery.plan.PlanContentConstant;
import com.lehecai.core.lottery.plan.util.PlanContentUnpacker;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreStringUtils;

/**
 * @author sunshow
 *
 */
public class FileReadTest {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
//		List<String> result = CoreFileUtils.getFileContentByLine("/Users/sunshow/Mine/Noname.txt", CharsetConstant.CHARSET_DEFAULT, null);
//		for (String string : result) {
//			System.out.println(string);
//		}
		
		String file = "D:/upload/plan/55/1111150001003944503.plan";
		
//		long t3 = System.currentTimeMillis();
//		System.out.println(t3);
//		CoreFileUtils.getFileContentByMappedBuffer(file, CharsetConstant.CHARSET_UTF8);
//		long t4 = System.currentTimeMillis();
//		System.out.println(t4);
//		System.out.println(t4 - t3);
		
		FileChannel fc = new FileInputStream(file).getChannel();
		
		long file_size = fc.size();
		
		long pos = 0;
		long buffer_size = 10240;
		long buffer_size_multipe = 100;
		
		long t1 = System.currentTimeMillis();
		System.out.println(t1);
		
		// 先map最后一部分取到倍数部分（包括分隔符在内，例如：!99）
		String multipleStr = null;
		{
			ByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, file_size - buffer_size_multipe, buffer_size_multipe);
			StringBuffer buffer = new StringBuffer(CoreStringUtils.convertByteBuffer(bb, CharsetConstant.CHARSET_UTF8));
			
			int index_multiple_char = buffer.indexOf(PlanContentConstant.MULTIPLE);
			multipleStr = buffer.substring(index_multiple_char);
			System.out.println(multipleStr);
		}
		
		int ticket_count = 0;
		
		while (pos + buffer_size <= file_size - multipleStr.length()) {
			ByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, pos, buffer_size);
			StringBuffer buffer = new StringBuffer(CoreStringUtils.convertByteBuffer(bb, CharsetConstant.CHARSET_UTF8));
			
			//System.out.println(buffer);
			int index_line_char = buffer.lastIndexOf(PlanContentConstant.LINE);
			String content = buffer.substring(0, index_line_char);
			
			PlanContent planContent = PlanContentUnpacker.unpack(content + multipleStr);
			ticket_count += planContent.getLines().size();
			
			//System.out.println("read: " + content + ", length: " + content.length());
			pos += content.length() + 1;
			//System.out.println(pos);
		}
		
		ByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, pos, fc.size() - pos - multipleStr.length());
		StringBuffer buffer = new StringBuffer(CoreStringUtils.convertByteBuffer(bb, CharsetConstant.CHARSET_UTF8));
		
		PlanContent planContent = PlanContentUnpacker.unpack(buffer.toString() + multipleStr);
		ticket_count += planContent.getLines().size();
		
		int index_multiple_char = buffer.indexOf(PlanContentConstant.MULTIPLE);
		if (index_multiple_char >= 0) {
			System.out.println("multiple_found");
		}
		System.out.println(buffer.toString());
		
		long t2 = System.currentTimeMillis();
		System.out.println(t2);
		System.out.println(t2 - t1);
		
		System.out.println(ticket_count);
		
		fc.close();
	}

}
