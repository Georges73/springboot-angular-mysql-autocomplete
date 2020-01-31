<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<input id="function-data" />
<input id="data-holder" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello ${name}!</title>
<script
	src="${pageContext.request.contextPath }/resources/js/jquery-1.4.2.js"></script>
<script
	src="${pageContext.request.contextPath }/resources/js/jquery-ui-1.8.2.custom.js"></script>
<link
	href="${pageContext.request.contextPath }/resources/css/themes/base/jquery.ui.all.css"
	rel="stylesheet" type="text/css">
	


<script type="text/javascript">


	$(document).ready(function() {
		$('#productName').autocomplete({
			minLength: 2,
			source : '${pageContext.request.contextPath }/product/search',
			 
			select: function(event, ui) {
				var keyword = ui.item.label;

				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath }/product/search_full?keyword=' + keyword,

					success: function(result){
					 var products = JSON.parse(result); 
				/* 	alert(result) */
				
					 var output = ''; 

					  for(var i = 0; i< products.length; i++){

						  

						  output += 'Id: ' + products[i].id + '<br>';
						  output += 'Name: <span style="background-color: #FFFF00">' + products[i].name + '</span> <br>';
						  output += 'Price: ' + products[i].price + '<br>';
						  output += 'Quantity: ' + products[i].description + '<br>';
						  output += '-----------------------------------------------<br>'; 
						
						 

						} 

					 $('#result').html(output) ;
						}
					
					
					});
				
				
				}
		});
	});

	
</script>
</head>
<body>
<div align="center">
	Search Product
	<input type="text" id="productName"> </div>
 <br><br>
 Result
 
<div id="result"></div> <br>


</body>
</html>




















<!-- <table>
        <tr>
            <td>prod search</td>
            <td><input type='text' id="productName" ></td>
        </tr>

       <tr>
            <td>the rest</td>
            <td><input type='text' id='selectuser_id' /></td>
        </tr>

        <tr>
            <td>Multiple Selection</td>
            <td><input type='text' id='multi_autocomplete' ></td>
        </tr>

        <tr>
            <td>Selected User ids</td>
            <td><input type='text' id='selectuser_ids' /></td>
        </tr>

    </table>
	 -->