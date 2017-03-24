<html>
<body>
	<h1>${message}</h1>
	<a href="/test/abc/def/ak">test AntPath</a>
	<br/>
	<a href="/test/pathvariable/1000">test PathVariable</a>
<br/>
	<form action="/test/restful/order" method="post">
		<input type="submit" value="testRestFulPost"/>
	</form>
	<br/>
	<a href="/test/restful/order/1000">test testRestfulGet</a>
	<br/>
	<form action="/test/restful/order/1000" method="post">
		<input type="hidden" name="_method" value="PUT"/>
		<input type="submit" value="testRestFulPut"/>
	</form>
<br/>
	<form action="/test/restful/order/1000" method="post">
		<input type="hidden" name="_method" value="DELETE"/>
		<input type="submit" value="testRestfulDelete"/>
	</form>

	<a href="/test/requestParam?name=gongtao&age=110">Test RequestParams</a>
</body>
</html>