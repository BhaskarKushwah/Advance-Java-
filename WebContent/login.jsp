
<!DOCTYPE html>

<head>
<style>
.divider:after, .divider:before {
	content: "";
	flex: 1;
	height: 1px;
	background: #eee;
}

.h-custom {
	height: calc(100% - 73px);
}

@media ( max-width : 450px) {
	.h-custom	
	height
	:
	100%;
}
}
<link rel="preconnect"
href="https://fonts.gstatic.com"crossorigin>
<link href="https:googleapis.com/css2?family=Poppins:ital,wght@0,500;1,100;1,200;1,300&display=swap" rel= "stylesheet">
</style> 
<%@include file="link.jsp"%>

</head>

<body>
	
	<section class="vh-100">
		<div class="container-fluid h-custom">
			<div
				class="row d-flex justify-content-center align-items-center h-100">

				<div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
					<form action="register" method="post">
						<div class="divider d-flex align-items-center my-4">
							<p class="text-center fw-bold mx-3 mb-0">Sign In</p>
						</div>
						<!-- Email input -->
						<div class="form-outline mb-4">
							<label class="form-label" for="form3Example3">Email
								address</label> <input type="email" id="form3Example3" name="email"
								class="form-control form-control-lg"
								placeholder="Enter a valid email address" />

						</div>

						<!-- Password input -->
						<div class="form-outline mb-3">
							<label class="form-label" for="form3Example4">Password</label> <input
								name="password" type="password" id="form3Example4"
								class="form-control form-control-lg"
								placeholder="Enter password" />
						</div>

						<div class="d-flex justify-content-between align-items-center">
							<!-- Checkbox -->
							<div class="form-check mb-0">
								<input class="form-check-input me-2" type="checkbox" value=""
									id="form2Example3" /> <label class="form-check-label"
									for="form2Example3"> Remember me </label>
							</div>
						</div>

						<div class="text-center text-lg-start mt-4 pt-2">
							<button type="submit" class="btn btn-primary btn-lg"
								name="button" value="login"
								style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
							<p class="small fw-bold mt-2 pt-1 mb-0">
								Don't have an account? <a href="register.jsp"
									class="link-danger">Register</a>
							</p>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- Right -->
	</section>

</body>