<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<head>
<%@include file="link.jsp"%>

</head>

<body>
	<section class="vh-100" style="background-color: #eee;">
		<div class="container h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-lg-12 col-xl-11">
					<div class="card text-black" style="border-radius: 25px;">
						<div class="card-body p-md-5">

							<div class="row justify-content-center">
								<div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">



									<form action="register" method="post">
										<div class="container">
											<div class="row">
												<div class="col">
													<div class="d-flex flex-row align-items-center mb-4">
														<i class="fas fa-user fa-lg me-3 fa-fw"></i>
														<div class="form-outline flex-fill mb-0">
															<label class="form-label" for="form3Example1c">First
																Name</label> <input type="text" id="form3Example1c"
																name="firstname" class="form-control" required />
														</div>
													</div>

													<div class="d-flex flex-row align-items-center mb-4">
														<i class="fas fa-user fa-lg me-3 fa-fw"></i>
														<div class="form-outline flex-fill mb-0">
															<label class="form-label" for="form3Example1c">Last
																Name</label> <input type="text" id="form3Example1c"
																name="lastname" class="form-control" required />
														</div>
													</div>


													<div class="d-flex flex-row align-items-center mb-4">
														<i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
														<div class="form-outline flex-fill mb-0">
															<label class="form-label" for="form3Example3c">
																Email</label> <input type="email" id="form3Example3c"
																name="email" class="form-control" />

														</div>

													</div>

													<div class="d-flex flex-row align-items-center mb-4">
														<i class="fas fa-user fa-lg me-3 fa-fw"></i>
														<div class="form-outline flex-fill mb-0">
															<label class="form-label" for="form3Example1c">Phone
																Number</label> <input type="text" id="form3Example1c"
																name="phone" class="form-control" />
														</div>
													</div>

													<div class="d-flex flex-row align-items-center mb-4">
														<i class="fas fa-lock fa-lg me-3 fa-fw"></i>
														<div class="form-outline flex-fill mb-0">
															<label class="form-label" for="form3Example4c ">Password</label>
															<input type="password" id="form3Example4c"
																name="password" class="form-control " required />

														</div>
													</div>
												</div>

												<div class="col">
													<div class="d-flex flex-row align-items-center mb-4">
														<i class="fas fa-user fa-lg me-3 fa-fw"></i>
														<div class="form-outline flex-fill mb-0">
															<label class="form-label" for="form3Example1c">Address</label>

															<input type="text" id="form3Example1c"
																class="form-control" name="address" />
														</div>
													</div>
													<div class="d-flex flex-row align-items-center mb-4">
														<i class="fas fa-user fa-lg me-3 fa-fw"></i>
														<div class="form-outline flex-fill mb-0">
															<label class="form-label" for="form3Example1c">City</label>

															<input type="text" id="form3Example1c"
																class="form-control" name="city" />
														</div>
													</div>
													<div class="d-flex flex-row align-items-center mb-4">
														<i class="fas fa-user fa-lg me-3 fa-fw"></i>
														<div class="form-outline flex-fill mb-0">
															<label class="form-label" for="form3Example1c">Zip
																Code</label> <input type="text" id="form3Example1c" name="zip"
																class="form-control" />
														</div>
													</div>
													<div class="d-flex flex-row align-items-center mb-4">
														<i class="fas fa-user fa-lg me-3 fa-fw"></i>
														<div class="form-outline flex-fill mb-0">
															<label class="form-label" for="form3Example1c">Sate</label>

															<input type="text" id="form3Example1c" name="state"
																class="form-control" />
														</div>
													</div>
													<div class="d-flex flex-row align-items-center mb-4">
														<i class="fas fa-user fa-lg me-3 fa-fw"></i>
														<div class="form-outline flex-fill mb-0">
															<label class="form-label" for="form3Example1c">Country</label>

															<input type="text" id="form3Example1c" name="country"
																class="form-control" />
														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="form-check d-flex justify-content-center mb-5">
											<input class="form-check-input me-2" type="checkbox" value=""
												id="form2Example3c" required /> <label
												class="form-check-label" for="form2Example3"> I
												agree all statements in <a href="#!">Terms of service</a>
											</label>
										</div>

										<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
											<button type="submit" name="button" value="sumbit"
												class="btn btn-primary btn-lg">Register</button>
										</div>

									</form>

								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>