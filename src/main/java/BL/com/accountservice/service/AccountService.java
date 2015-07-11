package bl.com.accountservice.service;

/**
 * Created by iKapralo on 30.06.2015.
 */
public interface AccountService
{
    /**
     * Retrieves current balance or zero if addAmount() method was not called before for specified id
     *
     * @param id balance identifier
     */
    Long getAmount(Integer id) throws Exception;
    /**
     * Increases balance or set if addAmount() method was called first time
     *  @param id balance identifier
     * @param value positive or negative value, which must be added to current balance
     */
    Long addAmount(Integer id, Long value) throws Exception;
}