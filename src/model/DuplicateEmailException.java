package model;

public class DuplicateEmailException extends RuntimeException {
  public DuplicateEmailException(String email) {
    super("O e-mail '" + email + "' já está cadastrado.");
  }
}
