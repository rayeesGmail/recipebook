package me.shaikhrayeesahmed.recipebook.repositories;

import me.shaikhrayeesahmed.recipebook.domains.Note;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteRepository extends PagingAndSortingRepository<Note, Long> {
}
