<%@page import="entidades.Personaje"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Combate</title>

	<link href="C:\Users\Juan Lucas\git\Web\Web\build\css\bootstrap.min.css" rel="stylesheet">

	<link href="C:\Users\Juan Lucas\git\Web\Web\build\css\signin.css" rel="stylesheet">
	
	<link href="C:\Users\Juan Lucas\git\Web\Web\build\css\Personajes.css" rel="stylesheet">
</head>

<body>
	<h1 class="headings-principal">Combate!</h1>
	<% 
		Personaje p1= ((Personaje)session.getAttribute("P1"));
		Personaje p2= ((Personaje)session.getAttribute("P2"));
	%>
	<div class="personaje">
	<form class="form-pers1" action="Combate">
	<h2>Personaje 1</h2>
	<label>Nombre</label>
    <input name="nombre1" type="text"  class="form-controlp1" disabled value=<%=p1.getNombre()%>>
	<br>
	<label>Vida</label>
    <input name="vida1" type="text"  class="form-controlp1" disabled value=<%=request.getAttribute("vida1")%>>
	<br>
	<label>Energia</label>
    <input name="energia1" type="text" class="form-controlp1" disabled value=<%=String.valueOf(p1.getEnergia()) %>>
    <br>
	<label>Defensa</label>
    <input name="defensa2" type="text" class="form-controlp1" disabled value=<%=String.valueOf(p1.getDefensa()) %>>
    <br>
	<label>Evasion</label>
    <input name="evasion1" type="text" class="form-controlp1" disabled value=<%=String.valueOf(p1.getEvasion()) %>>
	</form>
	</div>
	
	<div class="personaje">
	<form class="form-pers1" action="Combate">
	<h2>Personaje 2</h2>
	<label>Nombre</label>
    <input name="nombre2" type="text"  class="form-controlp1" disabled value=<%=p2.getNombre() %>>
	<br>
	<label>Vida</label>
    <input name="vida2" type="text"  class="form-controlp1" disabled value=<%=String.valueOf(p2.getVida()) %>>
	<br>
	<label>Energia</label>
    <input name="energia2" type="text" class="form-controlp1" disabled value=<%=String.valueOf(p2.getEnergia()) %>>
    <br>
	<label>Defensa</label>
    <input name="defensa2" type="text" class="form-controlp1" disabled value=<%=String.valueOf(p2.getDefensa()) %>>
    <br>
	<label>Evasion</label>
    <input name="evasion2" type="text" class="form-controlp1" disabled value=<%=String.valueOf(p2.getEvasion()) %>>
	</form>
	</div>
	
	<div class="acciones">
	<h2>Turno</h2>
	<input name="nombreTurno" type="text" class="form-controlp1" disabled value=<%=p1.getNombre() %> >
	<br>
	<h2>Energia</h2>
	<input name="energiaUsar" type="text" class="form-controlp1">
	<br>
	<button name="atacar" class="btn btn-primary btn-lg" type="submit">Atacar</button>
	<button name="defender" class="btn btn-lg btn-default" type="submit">Defender</button>
	</div>

</body>
</html>