<#import "temp1/defaultLayout.ftl" as layout>
<#import "/spring.ftl" as spring />
<@layout.myLayout1 "Home page"> 

<div class="container" style="margin-top: 40px">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <strong> Login to continue</strong>
                  <#if (welcome.message)??>
                   ${welcome.message}
                  </#if>
                  @{welcome.message}
                  
                    @{welcome.message}
                  
                </div>
                <div class="panel-body">
                    <form role="form" action="/login" method="POST">
                        <fieldset>
                            <div class="row">
                                <div class="col-sm-12 col-md-10  col-md-offset-1 ">
                                    <div class="form-group">
                                        <div class="input-group">
												<span class="input-group-addon"> <i
                                                        class="glyphicon glyphicon-user"></i>
												</span> <input type="text" id="email" name="email" class="form-control" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
												<span class="input-group-addon"> <i
                                                        class="glyphicon glyphicon-lock"></i>
												</span> <input type="password" id="password" name="password" class="form-control" /> <br />
                                        </div>
                                    </div>

                                    <div align="center" >
                                        <p style="font-size: 20; color: #FF1C19;">Email or
                                            Password invalid, please verify</p>
                                    </div>
                                    <div class="form-group">
                                        <input type="submit" class="btn btn-lg btn-primary btn-block"
                                               name="Submit" value="Login">
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
                <div class="panel-footer ">
                    Don't have an account! <a href="/registration" onClick="">
                    Register Here </a>
                </div>
            </div>
        </div>
    </div>
</div>


</@layout.myLayout1>