package com.himalaya.hdfs;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.junit.Test;

/**
 * @author: xuqu
 * @E-mail: fredxuqu@163.com
 * @version 2018年8月7日 下午3:13:50 Description
 */
public class HdfsClient {

	@Test
	public void test() {

		try {
			// System.setProperty("hadoop.home.dir",
			// "D:\\workspaces\\hadoop-2.7.2");

			Configuration configuration = new Configuration();

			configuration.set("fs.defaultFS", "hdfs://node101:9000");

			FileSystem fSystem = FileSystem.get(configuration);

			fSystem.copyFromLocalFile(new Path("D:/studynotes/hadoop/test.txt"), new Path("/test.txt"));

			fSystem.close();

			System.out.println("Finished....");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initHDFS() throws IOException {

		Configuration configuration = new Configuration();

		configuration.set("fs.defaultFS", "hdfs://node101:9000");

		FileSystem fSystem = FileSystem.get(configuration);

		System.out.println("=========" + fSystem.toString());
	}

	@Test
	public void uploadFileToHDFS() throws IOException {

		Configuration configuration = new Configuration();

		// 配置可以放到classpath底下，配置文件名称和hdfs服务器上面的etc/hadoop的一致
		configuration.set("fs.defaultFS", "hdfs://node101:9000");
		configuration.set("dfs.replication", "2");

		FileSystem fSystem = FileSystem.get(configuration);

		fSystem.copyFromLocalFile(new Path("D:/studynotes/hadoop/test.txt"), new Path("/test2.txt"));

		fSystem.close();
	}

	@Test
	public void downloadFileToLocal() throws IOException, InterruptedException, URISyntaxException {

		Configuration configuration = new Configuration();

		FileSystem fSystem = FileSystem.get(new URI("hdfs://node101:9000"), configuration, "fred");

		fSystem.copyToLocalFile(false, new Path("hdfs://node101:9000/usr/fred/input/wc.input"),
				new Path("D:/studynotes/hadoop"), true);

		fSystem.close();
	}

	@Test
	public void createDir() throws IOException, InterruptedException, URISyntaxException {

		Configuration configuration = new Configuration();

		FileSystem fSystem = FileSystem.get(new URI("hdfs://node101:9000"), configuration, "fred");

		fSystem.mkdirs(new Path("hdfs://node101:9000/usr/fred/test"));

		fSystem.close();
	}

	@Test
	public void removeDir() throws IOException, InterruptedException, URISyntaxException {

		Configuration configuration = new Configuration();

		FileSystem fSystem = FileSystem.get(new URI("hdfs://node101:9000"), configuration, "fred");

		fSystem.delete(new Path("hdfs://node101:9000/usr/fred/test"), true);

		fSystem.close();
	}

	@Test
	public void modifyFileName() throws IOException, InterruptedException, URISyntaxException {

		Configuration configuration = new Configuration();

		FileSystem fSystem = FileSystem.get(new URI("hdfs://node101:9000"), configuration, "fred");

		fSystem.rename(new Path("hdfs://node101:9000/test2.txt"), new Path("hdfs://node101:9000/update.txt"));

		fSystem.close();
	}

	@Test
	public void getHDFSDetails() throws IOException, InterruptedException, URISyntaxException {

		Configuration configuration = new Configuration();

		FileSystem fSystem = FileSystem.get(new URI("hdfs://node101:9000"), configuration, "fred");

		RemoteIterator<LocatedFileStatus> listFiles = fSystem.listFiles(new Path("/"), true);

		while (listFiles.hasNext()) {
			LocatedFileStatus status = listFiles.next();

			System.out.println(status.getPath().getName());
			System.out.println(status.getBlockSize());
			System.out.println(status.getOwner());
			BlockLocation[] blockLocations = status.getBlockLocations();
			for (BlockLocation blockLocation : blockLocations) {
				String[] hosts = blockLocation.getHosts();
				for (String host : hosts) {
					System.out.println(host);
				}
				String[] names = blockLocation.getNames();
				for (String name : names) {
					System.out.println(name);
				}
			}
		}

		fSystem.close();
	}

	@Test
	public void testFileOrDir() throws IOException, InterruptedException, URISyntaxException {

		Configuration configuration = new Configuration();

		FileSystem fSystem = FileSystem.get(new URI("hdfs://node101:9000"), configuration, "fred");

		FileStatus[] listStatus = fSystem.listStatus(new Path("/"));

		for (FileStatus fileStatus : listStatus) {
			if (fileStatus.isFile()) {
				System.out.println("f: " + fileStatus.getPath().getName());
			} else {
				System.out.println("d: " + fileStatus.getPath().getName());
			}
		}

		fSystem.close();
	}
}
