package esercizio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MainEsercizio {

	public static void main(String[] args) {

		List<Product> products = new ArrayList<>();
		Random rndm = new Random();
		products.add(new Product(rndm.nextLong(), "HARRY POTTER", "Books", 150));
		products.add(new Product(rndm.nextLong(), "THE WITCHER", "Books", 120));
		products.add(new Product(rndm.nextLong(), "IL CODICE DA VINCI", "Books", 50));
		products.add(new Product(rndm.nextLong(), "BIBERON", "Baby", 10));
		products.add(new Product(rndm.nextLong(), "PANNOLINI", "Baby", 20));
		products.add(new Product(rndm.nextLong(), "OMOGENIZZATI", "Baby", 15));
		products.add(new Product(rndm.nextLong(), "COMPUTER", "Boys", 700));
		products.add(new Product(rndm.nextLong(), "TELEVISORE", "Boys", 800));
		products.add(new Product(rndm.nextLong(), "CELLULARE", "Boys", 500));

		Customer cliente = new Customer(rndm.nextLong(), "Luca", 1);
		Customer cliente2 = new Customer(rndm.nextLong(), "Emma", 2);
		Customer cliente3 = new Customer(rndm.nextLong(), "Lillo", 3);

		List<Order> ordini = new ArrayList<>();
		ordini.add(new Order(rndm.nextLong(), "SPEDITO", LocalDate.now(), LocalDate.now().minusDays(4), "Baby",
				products, cliente));
		ordini.add(new Order(rndm.nextLong(), "DA SPEDIRE", LocalDate.now(), LocalDate.now().plusDays(3), "Books",
				products, cliente2));
		ordini.add(new Order(rndm.nextLong(), "DA SPEDIRE", LocalDate.now(), LocalDate.now().plusDays(5), "Baby",
				products, cliente3));

//-------------------------------------------------------------ESERCIZIO 1-----------------------------------------------------------------------
		List<Product> filtraProdotti = products.stream().filter(b -> b.getCategory().equals("Books"))
				.filter(b -> b.getPrice() > 100).collect(Collectors.toList());

		System.out.println("ESERCIZIO 1");
		System.out.println("");

		for (Product prodotti : filtraProdotti) {
			System.out.println("NUMERO ID" + prodotti.getId());
			System.out.println("TITOLO LIBRO: " + prodotti.getName());
			System.out.println("PREZZO: " + prodotti.getPrice());

			System.out.println("-------------------------------------------------------------------------------");
		}

//-------------------------------------------------------------ESERCIZIO 2-----------------------------------------------------------------------
		System.out.println("");
		System.out.println("ESERCIZIO 2");
		System.out.println("");

		List<Order> filtraOrdini = ordini.stream()
				.filter(o -> o.getProducts().stream().anyMatch(p -> p.getCategory().equals("Baby")))
				.collect(Collectors.toList());

		for (Order ord : filtraOrdini) {
			System.out.println("ORDINE EFFETUATO DA UTENTE: " + cliente.getId() + ":  " + cliente.getName()
					+ "-LIVELLO: " + cliente.getTier());
			System.out.println("ORDINE ID: " + ord.getId());
			System.out.println("CATEGORIA: " + ord.getCategory());
			System.out.println("DATA DI OGGI: " + ord.getOrderDate());
			System.out.println("STATO SPEDIZIONE: " + ord.getStatus());
			System.out.println("DATA SPEDIZIONE: " + ord.getDeliveryDate());

		}

//-------------------------------------------------------------ESERCIZIO 3-----------------------------------------------------------------------

		System.out.println("");
		System.out.println("ESERCIZIO 3");
		System.out.println("");

		List<Product> filtraProdottiBoys = products.stream().filter(b -> b.getCategory().equals("Boys")).map(b -> {
			double sconto = b.getPrice() * 0.9;
			b.setPrice(sconto);
			return b;
		}).collect(Collectors.toList());

		for (Product prodotto : filtraProdottiBoys) {
			System.out.println("PRODOTTO: " + prodotto.getName());
			System.out.println("NUMERO ID: " + prodotto.getId());
			System.out.println("CATEGORIA: " + prodotto.getCategory());
			System.out.println("PREZZO: " + prodotto.getPrice() / 0.9);
			System.out.println("PREZZO SCONTATO: " + prodotto.getPrice());
			System.out.println("--------------------------------");
		}

//-------------------------------------------------------------ESERCIZIO 4-----------------------------------------------------------------------		

		System.out.println("");
		System.out.println("ESERCIZIO 4");
		System.out.println("");
	}
}
