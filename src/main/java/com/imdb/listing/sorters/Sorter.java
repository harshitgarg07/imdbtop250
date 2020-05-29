package com.imdb.listing.sorters;

import java.util.LinkedList;

/**
 * @author harshitgarg
 *
 * @param <T>
 */
interface Sorter<T> {
	LinkedList<T> sortBy(LinkedList<T> fligtList);
}