package dao;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestNormal {
	public static void main(String[] args) {
		
//		var a = TestNormal.class.getResource("/icon/" + "admin.png");
//		System.out.println(a.toString());
		Path root2 = Paths.get(".").normalize().toAbsolutePath().getParent().getParent();
		System.out.println(root2);
	}
}
