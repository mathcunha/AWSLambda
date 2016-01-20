package br.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunctionHandler
		implements
		RequestHandler<LambdaFunctionHandler.RequestClass, LambdaFunctionHandler.ResponseClass> {

	// Define two classes/POJOs for use with Lambda function.
	public static class RequestClass {
		String firstName;
		String lastName;

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		@Override
		public String toString(){
			return String.format("Name is %s, %s.", firstName, lastName);
		}

		public RequestClass(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public RequestClass() {
		}
	}

	public static class ResponseClass {
		String greetings;

		public String getGreetings() {
			return greetings;
		}

		public void setGreetings(String greetings) {
			this.greetings = greetings;
		}

		public ResponseClass(String greetings) {
			this.greetings = greetings;
		}
		
		@Override
		public String toString(){
			return greetings;
		}

		public ResponseClass() {
		}
	}

	@Override
	public ResponseClass handleRequest(RequestClass input, Context context) {
		context.getLogger().log("Input: " + input);

		String greetingString = String.format("Hello %s, %s.", input.firstName,
				input.lastName);
		return new ResponseClass(greetingString);
	}

}
