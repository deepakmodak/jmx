public class Sample implements SampleMBean {
	private String message ;

	@Override
	public void printHelloWorld() {
		System.out.println(message);

	}
	@Override
	public void setMessage(String message) {
		this.message=message;

	}
	@Override
	public String getMessage() {
		return message;
	}
}