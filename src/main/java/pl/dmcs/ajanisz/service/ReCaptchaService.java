package pl.dmcs.ajanisz.service;

public interface ReCaptchaService {
    boolean verify(String captcha);
}
