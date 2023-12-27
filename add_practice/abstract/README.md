## The dynamic events disparcher demo
This pattern eliminates long switch statements and/or if statements in event handling.

For example, instead of

`switch (eventCode) {`

`case evAccelerate: player.accelerate(); break;`

`case evSlowDown: player.slowDown(); break;`

`case evTurnLeft: player.turnLeft(); break;`

`case evTurnRight: player.turnRight(); break;`

`}`

we can just write:

`movement[eventCode].move();`

This code demonstrates this approach.