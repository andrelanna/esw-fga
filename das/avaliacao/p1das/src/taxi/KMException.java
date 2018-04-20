package taxi;

public class KMException extends Exceptions{

	private static final long serialVersionUID = 1L;
	public static final String exc = "Km informado é 0.";
		
		public KMException() {
			super(exc);
		}
		
		public KMException(String exc) {
			super(exc);
		}

}
