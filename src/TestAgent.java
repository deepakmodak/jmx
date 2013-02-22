import java.lang.management.ManagementFactory;
import javax.management.MBeanServer;
import javax.management.ObjectName;

public class TestAgent {
	private MBeanServer mbserver = null;

	public TestAgent() {

		mbserver = ManagementFactory.getPlatformMBeanServer();
		Sample testBean = new Sample();
		testBean.setMessage("Hello World");
		ObjectName testName = null;

		try {

			testName = new ObjectName("FOO:name=SampleBean");
			mbserver.registerMBean(testBean, testName);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void executeIt() {
		try {
			System.out.println("Inside executeIt()");
			System.in.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String argv[]) {
		TestAgent agent = new TestAgent();

		System.out.println("TestAgent started");
		TestAgent.executeIt();
	}
}