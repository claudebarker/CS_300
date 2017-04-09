
public class CS_300_Main {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Quiz2_LLL_Barker test_LLL = new Quiz2_LLL_Barker();


		TestOBJ test = new TestOBJ();
		
		test_LLL.insert(0, test);
		test_LLL.insert(0, "test1");
		test_LLL.insert(0, "test2");
		test_LLL.insert(0, "test3");
		test_LLL.insert(0, "test4");
		test_LLL.insert(0, "test5");
		
		System.out.println("Data at index 3:" + test_LLL.getData(3));
		
		test_LLL.display();
		
		test_LLL.delete(3);
		
		test_LLL.display();
	}

}
