package app.requests.users

import app.datatypes.User

/**
 * Created by sparrow on 22.02.17.
 */
class UserBody {

    def static getBody(User user) {
        return """
    {
    "name": "${user.getName()}",
    "username": "${user.getUsername()}",
    "email": "${user.getEmail()}",
    "address": {
      "street": "Kulas Light",
      "suite": "Apt. 556",
      "city": "Gwenborough",
      "zipcode": "92998-3874",
      "geo": {
        "lat": "-37.3159",
        "lng": "81.1496"
      }
    },
    "phone": "${user.getPhone()}",
    "website": "${user.getWebsite()}",
    "company": {
      "name": "Romaguera-Crona",
      "catchPhrase": "Multi-layered client-server neural-net",
      "bs": "harness real-time e-markets"
    }
    }"""

    }
}
