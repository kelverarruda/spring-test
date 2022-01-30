$(document).ready(function() {

    $('#lista-projetos').DataTable({
        responsive: true,
        processing: true,
        stateSave: true,
        pagingType: 'full_numbers',
        oLanguage: {
            sSearch: 'Pesquisar',
            sLengthMenu: 'Mostrar _MENU_ registros por página',
            sInfo: 'Exibindo _START_ a _END_ de _TOTAL_ registros.',
            sInfoEmpty: 'Exibindo 0 até 0 de 0 registros.',
            sEmptyTable: 'Não há dados para serem exibidos',
            oPaginate: {
                sFirst: 'Primeira',
                sLast: 'Última',
                sPrevious: 'Anterior',
                sNext: 'Próxima'
            },
            sProcessing: 'Carregando...'
        },
        ajax: {
            url: '/api/projetos',
            method: 'GET',
            dataSrc: ''
        },
        columns: [
            { data : 'id' },
            { data: 'nome' },
            { data: 'data_inicio' },
            { data: 'data_fim' },
            {
                data: 'idgerente',
                render: function (data) {
                    if (data === '') {
                        return '';
                    }
                }
            },
            { data: 'orcamento' },
            {
                data: 'risco',
                render: function (data) {
                    var badge;
                    if (data === 'BAIXO_RISCO') {
                        badge = `<span class="badge bg-success">Baixo Risco</span>`;
                    } else if (data === 'MEDIO_RISCO') {
                        badge = `<span class="badge bg-warning">Médio Risco</span>`;
                    }
                    else {
                        badge = `<span class="badge bg-danger">Alto Risco</span>`;
                    }
                    return badge;
                }
            },
            {
                data: 'status',
                render: function (data) {
                    var badge;
                    if (data === 'EM_ANALISE') {
                        badge = `<span class="badge bg-primary">Em Análise</span>`;
                    }
                    else if (data === 'ANALISE_REALIZADA') {
                        badge = `<span class="badge bg-secondary">Análise Realizada</span>`;
                    }
                    else if (data === 'ANALISE_APROVADA') {
                        badge = `<span class="badge bg-warning">Análise Aprovada</span>`;
                    }
                    else if (data === 'INICIADO') {
                        badge = `<span class="badge bg-success">Iniciado</span>`;
                    }
                    else if (data === 'PLANEJADO') {
                        badge = `<span class="badge bg-light">Planejado</span>`;
                    }
                    else if (data === 'EM_ANDAMENTO') {
                        badge = `<span class="badge bg-info">Em Andamento</span>`;
                    }
                    else if (data === 'ENCERRADO') {
                        badge = `<span class="badge bg-dark">Encerrado</span>`;
                    }
                    else {
                        badge = `<span class="badge bg-danger">Cancelado</span>`;
                    }
                    return badge;
                }
            },
            {
                data: function (row) {
                    return row;
                },
                render: function (data) {

                    var btnEditar, btnExcluir;

                    btnEditar =
                        `<a href="projetos/editar?id=${data.id}" data-bs-toggle="tooltip" data-bs-placement="top" title="Editar">
                                            <button type="button" class="btn btn-info btn-sm">
                                                <i class="fas fa-pen"></i>
                                            </button>
                                        </a>`;
                    btnExcluir =
                        `<a href="projetos/excluir?id=${data.id}" data-bs-toggle="tooltip" data-bs-placement="top" title="Excluir">
                                            <button type="button" class="btn btn-danger btn-sm">
                                                <i class="fas fa-times-circle"></i>
                                            </button>
                                        </a>`;

                    return btnEditar + btnExcluir;
                }
            },
        ]
    });
});