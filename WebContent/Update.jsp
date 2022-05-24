<%@page import="service.OperationsEnp"%>
<%@page import="com.factory.SearchJdbc"%>
<%@page import="service.SearchEnp"%>
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

									<p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">UPDATE
										PAGE</p>

									<form action="HomeSvt
									" method="Post">
										<%
											String partyid = request.getParameter("id");

											//SearchEnp searchEnp=new SearchEnp();
											SearchJdbc searchJdbc = new SearchJdbc();
											OperationsEnp operationsEnp = searchJdbc.singleId(partyid);
										%>
										<div class="container">
											<div class="row">
												<div class="col">
													<div class="d-flex flex-row align-items-center mb-4">
														<i class="fas fa-user fa-lg me-3 fa-fw"></i>
														<div class="form-outline flex-fill mb-0">
															<label class="form-label" for="form3Example1c">First
																Name</label> <input type="text" id="form3Example1c"
																name="firstname" class="form-control"
																value=<%=operationsEnp.getFirstName()%> />
														</div>
													</div>

													<div class="d-flex flex-row align-items-center mb-4">
														<i class="fas fa-user fa-lg me-3 fa-fw"></i>
														<div class="form-outline flex-fill mb-0">
															<label class="form-label" for="form3Example1c">Last
																Name</label> <input type="text" id="form3Example1c"
																name="lastname" class="form-control"
																value=<%=operationsEnp.getLastName()%> />
														</div>
													</div>




													<div class="d-flex flex-row align-items-center mb-4">
														<i class="fas fa-user fa-lg me-3 fa-fw"></i>
														<div class="form-outline flex-fill mb-0">
															<label class="form-label" for="form3Example1c">Phone
																Number</label> <input type="text" id="form3Example1c"
																name="phone" class="form-control"
																value=<%=operationsEnp.getPhone()%> />
														</div>
													</div>
													<div class="d-flex flex-row align-items-center mb-4">
														<i class="fas fa-user fa-lg me-3 fa-fw"></i>
														<div class="form-outline flex-fill mb-0">
															<label class="form-label" for="form3Example1c">Address</label>

															<input type="text" id="form3Example1c"
																class="form-control" name="address"
																value=<%=operationsEnp.getAddress()%> />
														</div>
													</div>


												</div>

												<div class="col">

													<div class="d-flex flex-row align-items-center mb-4">
														<i class="fas fa-user fa-lg me-3 fa-fw"></i>
														<div class="form-outline flex-fill mb-0">
															<label class="form-label" for="form3Example1c">City</label>

															<input type="text" id="form3Example1c"
																class="form-control" name="city"
																value=<%=operationsEnp.getCity()%> />
														</div>
													</div>
													<div class="d-flex flex-row align-items-center mb-4">
														<i class="fas fa-user fa-lg me-3 fa-fw"></i>
														<div class="form-outline flex-fill mb-0">
															<label class="form-label" for="form3Example1c">Zip
																Code</label> <input type="text" id="form3Example1c" name="zip"
																class="form-control" value=<%=operationsEnp.getZip()%> />
														</div>
													</div>
													<div class="d-flex flex-row align-items-center mb-4">
														<i class="fas fa-user fa-lg me-3 fa-fw"></i>
														<div class="form-outline flex-fill mb-0">
															<label class="form-label" for="form3Example1c">Sate</label>

															<input type="text" id="form3Example1c" name="state"
																class="form-control" value=<%=operationsEnp.getState()%> />
														</div>
													</div>
													<div class="d-flex flex-row align-items-center mb-4">
														<i class="fas fa-user fa-lg me-3 fa-fw"></i>
														<div class="form-outline flex-fill mb-0">
															<label class="form-label" for="form3Example1c">Country</label>

															<input type="text" id="form3Example1c" name="Country"
																class="form-control"
																value=<%=operationsEnp.getCountry()%> />
														</div>
													</div>


												</div>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-user fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<label class="form-label" for="form3Example1c"> </label> <input
													type="hidden" id="form3Example1c" name="partyid"
													class="form-control" value=<%=operationsEnp.getPratyid()%> />
											</div>
										</div>
										<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
											<button type="submit" name="button" value="update"
												class="btn btn-primary btn-lg">Update</button>
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