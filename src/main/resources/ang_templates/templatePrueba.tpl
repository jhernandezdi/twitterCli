Nombre:${model.nombre}
<%
model.lista.each{num->
%>
Num:${num}
<%
}// num each
%>
Obj.campo1:${model.obj.campo1}
Obj.campo2:${model.obj.campo2}<%
//Probar con un json simple del estilo {"nombre":"JPGP","lista":[1,2,3,4],"obj":{"campo1":"val1","campo2":"val2"}}
%>