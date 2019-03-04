<%@ page pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Attraction Finder</title>
</head>
<style>
	body{text-align:center;}
	form{height:50vh; width:25vw; margin:auto; text-align:left;}
	nav{max-height:50vh; overflow:hidden; overflow-y:scroll; border-width:1px; border-style:solid; padding:10px;}
	#submitButton{width:100%;}
</style>
<body>
	<h1>Attraction Finder</h1>
	<form id="tagSelection">
		<nav><%--This is the format for the Tag options once the databse is hooked up--%>
			<input type="checkbox" name="tag1" value="tag1">Tag 1<br>
			<input type="checkbox" name="tag2" value="tag2">Tag 2<br>
			<input type="checkbox" name="tag3" value="tag3">Tag 3<br>
		</nav>
		<br>
		<input type="submit" value="Search" id="submitButton">
	</form>
</body>
</html>