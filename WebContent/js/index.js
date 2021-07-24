
var low=0, high=10;
var loadedData = [];

const changeTable = (s) => {
	var table = document.getElementById("whole-table");
	while(table.rows.length>1){
			table.deleteRow(1);	
	}
	let temp=0;
	for(let idx=low; idx<high && idx<loadedData.length; idx++){
			var rowk = table.insertRow(temp+1);
			var cell1 = rowk.insertCell(0);
			var cell2 = rowk.insertCell(1);
			var cell3 = rowk.insertCell(2);
			var cell4 = rowk.insertCell(3);
			var cell5 = rowk.insertCell(4);
			var cell6 = rowk.insertCell(5);
			var cell7 = rowk.insertCell(6);
			var cell8 = rowk.insertCell(7);
			cell1.innerHTML = "<label class="+"checkbox-label"+"><input type="+"checkbox"+"><span class="+"checkbox-custom rectangular"+"></span></label>";
			cell2.innerHTML = loadedData[idx].name_customer;
			cell3.innerHTML = loadedData[idx].cust_number;
			cell4.innerHTML = loadedData[idx].invoice_id;
			cell5.innerHTML = loadedData[idx].total_open_amount;
			cell6.innerHTML = loadedData[idx].due_in_date;
			cell7.innerHTML = loadedData[idx].predicted_payment_date;
			cell8.innerHTML = "Note";
			temp++;
	}
}

const Fetcher = () => {
	fetch("http://localhost:8080/Summer_Internship_Backend/fetchTableServlet")
	.then(res => res.json())
	.then(data => {
		loadedData = data;
		changeTable(0);
	});	
}
Fetcher();

const left = () => {
	if(low>=10){
		high=low;
		low-=10;
	}
	changeTable(1);
}

const right = () => {
	if(high<=loadedData.length){
		if(high>=loadedData.length-10){
			low=high;
			high=loadedData.length-1;
		}else {
			low=high;
			high+=10;	
		}
	}
	changeTable(2);
}

const invoiceChange = ()=>{
	var inv = document.getElementById('invoice-search').value;
	if(inv.length===10){
		fetch("http://localhost:8080/Summer_Internship_Backend/fetchInvoice", { 
			method: 'POST',
			headers: {
	      		'Accept': 'application/json',
	      		'Content-Type': 'application/json'
	    	},
			body: inv
		})
		.then(res => res.json())
		.then(data => {
			loadedData = data;
			changeTable(0);
		});
	} else{
		document.getElementById('invoice-search').value="";
		Fetcher();
	}
}

const inputCrossEvent = () => {
	document.getElementById('invoice-search').value="";
	Fetcher();
}

const clickOutside = (e) =>{
	console.log(e);
	if(e.target == document.getElementById('overlay')){
	  document.getElementById('overlay').style.display='none';
	}
}

window.addEventListener('click',clickOutside);


const add = () => {
	document.getElementById('overlay').style.display="block";
}
const closeAdd = () => {
	document.getElementById('overlay').style.display="none";
}

const clearAdd = () => {
	document.getElementById('name_customer').value="";
	document.getElementById('cust_number').value="";
	document.getElementById('invoice_id').value="";
	document.getElementById('due_date').value="";
	document.getElementById('invoice_amount').value="";
	document.getElementById('notes').value="";
}

const addInvoice = () =>{
	invoiceObject = {
		name_customer: document.getElementById('name_customer').value,
		cust_number: document.getElementById('cust_number').value,
		invoice_id: document.getElementById('invoice_id').value,
		due_in_date: document.getElementById('due_date').value,
		invoice_amount: document.getElementById('invoice_amount').value,
		notes: document.getElementById('notes').value
	};
	console.log(invoiceObject);
	
	fetch("http://localhost:8080/Summer_Internship_Backend/addInvoiceServlet", { 
			method: 'POST',
			headers: {
	      		'Accept': 'application/json',
	      		'Content-Type': 'application/json'
	    	},
			body: JSON.stringify(invoiceObject)
		})
		.then(res => res.json())
		.then(data => {
			console.log(data);
		});
}

/*<tr>
						    <td>
						    	<label class="checkbox-label">
					            	<input type="checkbox">
					            	<span class="checkbox-custom rectangular"></span>
					        	</label>
						    </td>
						    <td>Smith</td>
						    <td>50</td>
						    <td>Jill</td>
						    <td>Smith</td>
						    <td>50</td>
						    <td>Jill</td>
						    <td>Smith</td>
						  </tr>
				*/