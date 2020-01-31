<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	$(document)
			.ready(
					function() {

						
						$('#productName')
								.autocomplete(
										{
											minLength : 2,
											source : '${pageContext.request.contextPath }/product/search', /* declare sourc variable */

											select : function(event, ui) {  /* click event dans ui to fire method*/ 
												/* alert(event) */
												
												var inputFromBox = ui.item.label;
												searchResults = [];

												$
														.ajax({
															type : 'GET',
															url : '${pageContext.request.contextPath }/product/search_full?inputParam='	+ inputFromBox,
															dataType: 'json',

						/* ************************************* FUNCTION *****************************************************************************/
						
														
													        success: function(response) {
													          console.log(typeof(response));
													          
													          var html_to_append = '';
													          $.each(response, function(i, item) {

														          
													            html_to_append +=  '<div class="col-3 mb-3"><div class="text-uppercase"><p>' +
													            item.id +   '<div class="col-3 mb-3"><div class="ext-uppercase"><p>' +
													            item.name + '<div class="col-3 mb-3"><div class="ext-uppercase"><p>' +
													            item.description +'<div class="col-3 mb-3"><div class="ext-uppercase"><p>' +
													            item.price +
													            '</p></div>';
													          });

													          
													          $("#result").html(html_to_append);
													        },
													       
													      });

											}
										});
					});
</script>
</head>
<body>

	<div id="backcontainer">
		<div align="center">

			Search Product <input type="text" id="productName">
		</div>
	</div>

	<br>
	<br> Result

	<div id="result"></div>
	<br>


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