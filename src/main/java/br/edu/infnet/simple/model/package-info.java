@org.hibernate.annotations.NamedQueries(
		@org.hibernate.annotations.NamedQuery(
				name = "findItensOrderByName",
				query = "select i from Item i order by i.name asc"
				)
		)
package br.edu.infnet.simple.model;
