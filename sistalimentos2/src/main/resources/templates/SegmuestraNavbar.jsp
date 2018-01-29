
<div id="navbar" class="navbar">
    <div class="navbar-inner">
        <div class="container-fluid">
            <form name="FormOpcMain" id="FormOpcMain" method="post" action="SPrincipal">
                <input type="hidden" name="pAccion" value="">
                <a href="#" class="brand">
                    <small>
                        <img src="/${initParam.Nombre}/recursos/images/logo.png" alt="Programa Integral Nacional para el Bienestar Familiar - INABIF">
                    </small>
                </a>
                <a href="#" class="brand" style="font-size: 14px;color:#aaa;">
                    <small>
                        ${sessionScope.sistemaSession.sisnombre} - ${sessionScope.sistemaSession.sisversion}
                    </small>
                </a>
                <a href="#" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">
                    <i class="icon-reorder"></i>  
                </a>
                <ul class="nav flaty-nav pull-right">
                    <!-- BEGIN Button User -->
                    <li class="user-profile">
                        <a data-toggle="dropdown" href="#" class="user-menu dropdown-toggle">
                            <span class="hidden-phone" id="user_info">
                                ${sessionScope.personaSession.pernombre} ${sessionScope.personaSession.perapepaterno} ${sessionScope.personaSession.perapematerno}
                            </span>
                            <i class="icon-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-navbar" id="user_menu">
                            <li>
                                <a href="javascript:CallOpcMain(1)">
                                    <i class="icon-cog"></i>Listado de Sistemas
                                </a>
                            </li>
                            <!--li>
                                <a href="javascript:CallOpcMain(3)">
                                    <i class="icon-cog"></i>Perfil de Usuario
                                </a>
                            </li-->
                            <li>
                                <a href="javascript:CallOpcMain(2)">
                                    <i class="icon-off"></i>Salir
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </form>
        </div>
    </div>
</div>
