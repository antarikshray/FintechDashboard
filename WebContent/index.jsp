<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Highradius</title>
<link rel="stylesheet" href="./css/index.css">
</head>
<body>
	<div class="main_bod">
		<div class="headbar">
			<div class="brand">
				<img class="title" src="./images/Group 20399.svg" />
			</div>
			<div class="logo-div">
				<img class="logo" src="./images/icons/logo.svg" />
			</div>
		</div>
		<div class="table-header">
			<h1 class="table-title">Invoice List</h1>
		</div>
		<div class="content">
			<div class="content-container">
				<div class="buttons-row">
					<div style="width:1106px;"></div>
					<button class="buttons-1" onClick="add()" ><img src="./images/plus.svg" /> Add</button>
					<button class="buttons-2"><img src="./images/edit.svg" /> Edit</button>
					<button class="buttons-2"><img src="./images/minus.svg" style="margin-bottom: 1vh" /> Delete</button>
				    <input id="invoice-search" onChange="invoiceChange()" type="search" class="input-1" style="margin-right: 30px;" paceholder="Search by Invoice Number" value="" />
				    <button class="input-cross" onClick="inputCrossEvent()" ><img src="./images/cross.svg" /></button>
				</div>
				
				<div class="table-container">
				
					<button class="left-btn" onClick="left()" ><img style="height: 21px;" src="./images/icons/arrow.png" /></button>
					<div class="table">
						<table id="whole-table" style="width:100%" class="t01">
						  <tr>
						  	<th>
						  	<label class="checkbox-label">
					            <input type="checkbox">
					            <span class="checkbox-custom rectangular"></span>
					        </label>
        					</th>
						  	<th>Customer Name</th>
						  	<th>Customer #</th>
						  	<th>Invoice #</th>
						  	<th>Invoice Amount</th>
						  	<th>Due Date</th>
						  	<th>Predicted Payment Date</th>
						  	<th>Notes</th>
						  </tr>
						</table>
					</div>
					<button class="right-btn" onClick="right()" ><img style="height: 21px" src="./images/icons/arrow.png" /></button>
					
				</div>
				
			</div>
		</div>
	</div>
	
	<div id="overlay" class="overlay">
	<div class="overlay-container">
			<div class="overlay-header">
			<h1 class="overlay-title">Add Invoice</h1>
			<img onClick="closeAdd()" src="./images/cross.svg" >
			</div>
			<div class="input-row">
				<label style="font: normal normal normal 20px/24px Ubuntu; letter-spacing: 0.19px; color: #97A1A9;" >Customer Name *</label>
				<input class="overlay-inputs" id="name_customer" />
				<label style="font: normal normal normal 20px/24px Ubuntu; letter-spacing: 0.19px; color: #97A1A9;">Due Date *</label>
				<input class="overlay-inputs" type="date" id="due_date" />
			</div>
			<div class="input-row">
				<label style="font: normal normal normal 20px/24px Ubuntu; letter-spacing: 0.19px; color: #97A1A9;">Customer Number *</label>
				<input class="overlay-inputs" id="cust_number" />
				<label style="font: normal normal normal 20px/24px Ubuntu; letter-spacing: 0.19px; color: #97A1A9;">Notes *</label>
				<input class="overlay-inputs" id="notes" />
			</div>
			<div class="input-row-1">
				<label style="font: normal normal normal 20px/24px Ubuntu; letter-spacing: 0.19px; color: #97A1A9;">Invoice No. *</label>
				<input class="overlay-inputs" id="invoice_id" />
			</div>
			<div class="input-row-1">
				<label style="font: normal normal normal 20px/24px Ubuntu; letter-spacing: 0.19px; color: #97A1A9;">Invoice Amount *</label>
				<input class="overlay-inputs" id="invoice_amount" />
			</div>
			<div class="submit-row">
			<button onClick="closeAdd()" style="text-align: left; font: normal normal normal 20px/24px Ubuntu; letter-spacing: 0px; color: #14AFF1;"> Cancel </button>
			<div>
				<button style="width: 87px;height: 45px;border: 1px solid #14AFF1;border-radius: 10px;opacity: 1; font: normal normal normal 20px/24px Ubuntu;letter-spacing: 0px;color: #FFFFFF;" onClick="clearAdd()">Clear</button>
				<button style="width: 77px;height: 45px;background: #14AFF1 0% 0% no-repeat padding-box;border-radius: 10px;opacity: 1; font: normal normal normal 20px/24px Ubuntu;letter-spacing: 0px;color: #FFFFFF;" onClick="addInvoice()">Add</button>
			</div>
			</div>
	</div>
	</div>
</body>
<script src="./js/index.js">
</script>
</html>
