<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
	<head>
	<title><tiles:getAsString name="title" /></title>
	<script type="text/javascript" src="./js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#submit").click(function(){
			alert($("#drink").val());
			$.post("here", {execution: $('#key').val(), ajaxSource: "true", drink: $("#drink").val(), _eventId_submit: "submit"}, function(data){
				alert(data);
				$("#footer").html(data);	
			});
			return false;
		});
	});
	
	</script>
	</head>
	<body>
		<header>
			<tiles:insertAttribute name="header" />
		</header>
		<div class="wrapper">
			<tiles:insertAttribute name="body" />
			<tiles:insertAttribute name="menu" />
		</div>
		<tiles:insertAttribute name="footer" />
	</body>
</html>