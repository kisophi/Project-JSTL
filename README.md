# Project-JSTL 
## Sistema Java basico
### Maven dependency
##### - MySQL 8.0.20
##### - Servlet api 4.0.1
##### - JSTL 1.2
#### Sistema basico com um CRUD de usuario em JSP com controle de acesso
### CRUD simples
<table>
   <tr>
      <th>Metodos</th>
      <th>Descricao</th>
   </tr>
   <tr>
      <td>addUser</td>
      <td>Adiciona um novo Usuario</td>
   </tr>
   <tr>
      <td>deleteUser</td>
      <td>Exclui um Usuario</td>
   </tr>
   <tr>
      <td>updateUser</td>
      <td>Atualiza um Usuario</td>
   </tr>
   <tr>
      <td>allUsers</td>
      <td>Mostra todos Usurios do banco</td>
   </tr>
   <tr>
      <td>findByName</td>
      <td>Busca os Usuarios pelo nome</td>
   </tr>
   </tr>
   <tr>
      <td>findById</td>
      <td>Busca o Usuario pelo ID</td>
   </tr>
   <tr>
      <td>userAutentication</td>
      <td>Verifica se login é verdadeiro</td>
   </tr>
</table>


### Tela do allUsers.jsp
![table list](https://user-images.githubusercontent.com/14569809/83801150-06997880-a67f-11ea-8e0f-0cac892b33cf.PNG)


### Tela de Novo Usuario
![tela novo Usuario](https://user-images.githubusercontent.com/14569809/83802132-9d1a6980-a680-11ea-80fa-a31e4052bcd6.PNG)


### Tela de Login
![tela de Login](https://user-images.githubusercontent.com/14569809/83800640-1f555e80-a67e-11ea-9633-e10e6ba76767.PNG)
- Verifica o Usuario e a senha no banco de dados
- Caso não consta no banco exibira a mensagem de Usuario invalido
