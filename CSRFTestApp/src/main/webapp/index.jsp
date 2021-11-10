


    
    <hr>
    
      <form action="http://localhost:3030/BootSecurity04-FORM-DB-SpringDataJPA-CSRF/bank/balance"  method="POST">
            <input type="submit"  value="Click here to win lottery"/>
            <input type="hidden"  th:name="${_csrf.parameterName}"  th:value="${_csrf.token}"/>
      </form>
    