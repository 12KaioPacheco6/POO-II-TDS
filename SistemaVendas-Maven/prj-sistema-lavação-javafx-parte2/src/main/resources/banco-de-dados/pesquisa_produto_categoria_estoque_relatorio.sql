select produto.*, categoria.descricao, motor.quantidade
from produto
join categoria on produto.id_categoria=categoria.id
left join motor on motor.id_produto=produto.id
order by produto.id;