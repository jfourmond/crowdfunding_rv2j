<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Listes des commentaires</title>
		<%@include file="/WEB-INF/favicon.jsp" %>
		<link rel="stylesheet" href="<c:url value="/css/material.min.css"/>" />
		<script src="<c:url value="/js/material.min.js"/>" ></script>
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<style>
			.mdl-layout {
				align-items: center;
			}
			.mdl-layout__content {
				padding: 24px;
				flex: none;
			}
			form {
				padding-top: 25px;
			}
		</style>
	</head>
	<body>
		<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
			<%@include file="/WEB-INF/headband.jsp" %>
			<h1>Commentaires</h1>
			<form action="commentaries_list" method="post">
				<table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
					<thead>
						<tr>
							<th>ID</th>
							<th>ID Auteur</th>
							<th class="mdl-data-table__cell--non-numeric">Texte</th>
							<th class="mdl-data-table__cell--non-numeric">Date de création</th>
							<th class="mdl-data-table__cell--non-numeric">Date de dernière mise à jour</th>
							<th><!-- BOUTON D'EDITION --></th>
							<th><!-- BOUTON DE SUPPRESSION --></th>
						</tr>
					</thead>
	<!--			<tbody>
						<c:choose>
							<c:when test="${ !empty commentaries }">
								<c:forEach var="commentary" items="${commentaries}" >
									<tr>
										<td>${commentary.ID}</td>
										<td>${commentary.authorID}</td>
										<td class="mdl-data-table__cell--non-numeric">
											<a href="
												<c:url value="/commentary">
													<c:param name="id" value="${commentary.ID}"/>
												</c:url> ">
											</a>
										</td>
										<td class="mdl-data-table__cell--non-numeric">${fn:substring(commentary.comment,0,30)}</td>
										<td class="mdl-data-table__cell--non-numeric">${commentary.creationDate}</td>
										<td class="mdl-data-table__cell--non-numeric">${commentary.lastUpdateDate}</td>
										<td><button class="mdl-button mdl-js-button mdl-button--raised" type="submit" name="edit" value="${commentary.ID}">Editer</button></td>
										<td><button class="mdl-button mdl-js-button mdl-button--raised" type="submit" name="delete" value="${commentary.ID}">Supprimer</button></td>
									</tr>
								</c:forEach>
							</c:when>
						</c:choose>
					</tbody>  -->	
				</table>
			</form>
			<form action="commentaries_list" method="post">
				<button class="mdl-button mdl-js-button mdl-button--fab" type="submit" name="add">
					<i class="material-icons">add</i>
				</button>
			</form>
		</div>
	</body>
</html>