package com.flhub.ideams.models;




// public class SpringSecurityAuditorAware implements AuditorAware<String> {

// 	@Override
// 	public Optional<String> getCurrentAuditor() {
		
// 		// Just return a string representing the username
// 		return Optional.ofNullable("Godwin").filter(s -> !s.isEmpty());
// 	}
	
// }

// public class SpringSecurityAuditorAware implements AuditorAware<String> {

// 	  public Optional<String> getCurrentAuditor() {

// 	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

// 	    if (authentication == null || !authentication.isAuthenticated()) {
// 	      return null;
// 	    }

// 	    return Optional.of(((MyUserDetails) authentication.getPrincipal()).getUsername());
// 	  }
// }
