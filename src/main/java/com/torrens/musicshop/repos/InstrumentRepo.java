package com.torrens.musicshop.repos;

import com.torrens.musicshop.domain.Instrument;
import org.springframework.data.repository.CrudRepository;

public interface InstrumentRepo extends CrudRepository<Instrument, Integer> {
}
