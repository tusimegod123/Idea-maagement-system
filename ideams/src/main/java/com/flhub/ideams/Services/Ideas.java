package com.flhub.ideams.Services;

import org.springframework.data.domain.Page;

import com.flhub.ideams.models.Idea;



public interface Ideas {
	Page<Idea> findPaginated(int pageNo, int pageSize);

}
