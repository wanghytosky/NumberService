# NumberService
status 
	get  get status of the number
	his  get histories of a number or a customer
	update update the status of the number and insert a record into history table
customer
	get get customer info by cus_id
	delete delete customer record by cus_id if the each of the numbers under him is not in use
	update update customer's information
	
number
	create create a new number
	search search out the number information by num_id
	delete delete the number record by num_id if the number is not in use
	update update number infomation by num_id



![Architecture Diagram](https://raw.githubusercontent.com/wanghytosky/NumberService/master/NumberService.jpeg)
