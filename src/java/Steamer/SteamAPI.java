/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Steamer;

import com.github.goive.steamapi.SteamApi;
import com.github.goive.steamapi.SteamApiFactory;
import com.github.goive.steamapi.data.SteamApp;
import com.github.goive.steamapi.enums.CountryCode;

/**
 *
 * @author Maxkarpov
 */
public class SteamAPI {
    
    public SteamApi steamApi;
    public SteamApp steamApp;
            
    public SteamAPI()
    {
        steamApi = SteamApiFactory.createSteamApi(CountryCode.AT);
        steamApp = steamApi.retrieveApp(730); // appId of Half-Life
    }
    
    public void doStuff()
    {
        
    
    }
    
}
