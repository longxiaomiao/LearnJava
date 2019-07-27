<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" isELIgnored="false"%>
  
<div style="margin:0px auto; width:500px">
  
<form action="UpdateCategory" method="post">
  
name: <input name="name" value="${categoryInfo.name}"> <br>
  
<input name="id" type="hidden" value="${categoryInfo.id}">
<button type="submit">提交</button>
  
</form>
</div>